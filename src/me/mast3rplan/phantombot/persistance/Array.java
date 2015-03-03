/* 
 * Copyright (C) 2015 www.phantombot.net
 *
 * Credits: mast3rplan, gmt2001, PhantomIndex, GloriousEggroll
 * gloriouseggroll@gmail.com, phantomindex@gmail.com
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package me.mast3rplan.phantombot.persistance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Array {
    private ArrayList<String> data;
    private ReentrantLock lock;
    private String file;

    public static Array create(String file) {
        Array array = new Array();
        array.data = new ArrayList();
        array.file = file;
        array.lock = new ReentrantLock();
        array.readFile();
        return array;
    }

    public String getElement(int index) {
        String s;
        try {
            this.lock.lock();
            s = this.data.get(index);
        }
        finally {
            this.lock.unlock();
        }
        return s;
    }

    public int getSize() {
        int i;
        try {
            this.lock.lock();
            i = this.data.size();
        }
        finally {
            this.lock.unlock();
        }
        return i;
    }

    public void insert(String s) {
        try {
            this.lock.lock();
            this.data.add(s);
        }
        finally {
            this.lock.unlock();
        }
        new SyncFile(this).run();
    }

    private void readFile() {
        new ReadFile(this).run();
    }

    private Array() {
    }

    private class SyncFile
    implements Runnable {
        Array array;

        @Override
        public void run() {
            try {
                this.array.lock.lock();
                FileOutputStream fos = new FileOutputStream(this.array.file);
                PrintStream ps = new PrintStream(fos);
                for (String s : this.array.data) {
                    ps.println(s);
                }
                try {
                    fos.close();
                }
                catch (IOException ex) {
                    // empty catch block
                }
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(Array.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                this.array.lock.unlock();
            }
        }

        SyncFile(Array a) {
            this.array = a;
        }
    }

    private class ReadFile
    implements Runnable {
        Array array;

        @Override
        public void run() {
            try {
                this.array.lock.lock();
                FileInputStream fis = new FileInputStream(this.array.file);
                Scanner fscn = new Scanner(fis);
                while (fscn.hasNextLine()) {
                    this.array.data.add(fscn.nextLine());
                }
                try {
                    fis.close();
                }
                catch (IOException ex) {
                    // empty catch block
                }
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(Array.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                this.array.lock.unlock();
            }
        }

        ReadFile(Array a) {
            this.array = a;
        }
    }

}

