/* 
 * Copyright (C) 2015 www.phantombot.net
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.mast3rplan.phantombot.jerklib;

/**
 * A class to hold information about Username, Realname, Nick,RealName,AltNic
 * etc.
 *
 * @author mohadib
 * @see
 * ConnectionManager#ConnectionManager(me.mast3rplan.phantombot.jerklib.Profile)
 * @see ConnectionManager#requestConnection(String, int,
 * me.mast3rplan.phantombot.jerklib.Profile)
 */
public class Profile
{

    private String name, realName, actualNick, firstNick, secondNick, thirdNick;

    /**
     * Create a new Profile
     *
     * @param name Username
     * @param realName real name
     * @param nick Nick
     * @param secondNick Alt nick 1
     * @param thirdNick Alt nick 2
     */
    public Profile(String name, String realName, String nick, String secondNick, String thirdNick)
    {
        this.realName = realName == null ? name : realName;
        this.name = name == null ? "" : name;
        this.firstNick = nick == null ? "" : nick;
        this.secondNick = secondNick == null ? "" : secondNick;
        this.thirdNick = thirdNick == null ? "" : thirdNick;
        actualNick = firstNick;
    }

    /**
     * Create a new Profile
     *
     * @param name Username
     * @param nick Nick
     * @param secondNick Alt nick 1
     * @param thirdNick Alt nick 2
     */
    public Profile(String name, String nick, String secondNick, String thirdNick)
    {
        this.realName = name;
        this.name = name == null ? "" : name;
        this.firstNick = nick == null ? "" : nick;
        this.secondNick = secondNick == null ? "" : secondNick;
        this.thirdNick = thirdNick == null ? "" : thirdNick;
        actualNick = firstNick;
    }

    /**
     * Create a new Profile. Alt. nicks will be generated by adding the number 1
     * or 2 to the end of the nick.
     *
     * @param name username
     * @param realName
     * @param nick
     */
    public Profile(String name, String realName, String nick)
    {
        this(name, realName, nick, nick + "1", nick + "2");
    }

    /**
     * Create a new Profile. Name is set to nick. Alt. nicks will be generated
     * by adding the number 1 or 2 to the end of the nick.
     *
     * @param nick
     */
    public Profile(String nick)
    {
        this(nick, nick, nick, nick + "1", nick + "2");
    }

    /**
     * return the name
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Rreturn the first nick
     *
     * @return first nick
     */
    public String getFirstNick()
    {
        return firstNick;
    }

    /**
     * Get the second nick
     *
     * @return second nick
     */
    public String getSecondNick()
    {
        return secondNick;
    }

    /**
     * Get the third nick
     *
     * @return third nick
     */
    public String getThirdNick()
    {
        return thirdNick;
    }

    /**
     * Get the nick currently being used.
     *
     * @return current actual nick
     */
    public String getActualNick()
    {
        return actualNick;
    }

    /**
     * Set current nick
     *
     * @param aNick
     */
    void setActualNick(String aNick)
    {
        actualNick = aNick;
    }

    /**
     * Set first nick
     *
     * @param nick
     */
    void setFirstNick(String nick)
    {
        firstNick = nick;
    }

    /**
     * get the rewal name
     *
     * @return real name
     */
    public String getRealName()
    {
        return realName;
    }

    /**
     * Set the real name
     *
     * @param realName
     */
    public void setRealName(String realName)
    {
        this.realName = realName;
    }/* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */


    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Profile profile = (Profile) o;

        if (actualNick != null ? !actualNick.equals(profile.getActualNick()) : profile.getActualNick() != null)
        {
            return false;
        }
        if (name != null ? !name.equals(profile.getName()) : profile.getName() != null)
        {
            return false;
        }

        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        int result;
        result = (name != null ? name.hashCode() : 0);
        result = 31 * result + (actualNick != null ? actualNick.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Profile clone()
    {
        Profile impl = new Profile(name, realName, firstNick, secondNick, thirdNick);
        impl.setActualNick(actualNick);
        return impl;
    }
}
