/* 
 * Copyright (C) 2016 www.quorrabot.com
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
package me.gloriouseggroll.quorrabot.event.gamewisp;

import me.gloriouseggroll.quorrabot.twitchchat.Channel;
/**
 *
 * @author Tom
 */
public class GameWispAnniversaryEvent extends GameWispEvent {

    private final String username;
    private final int months;
    private final int tier;

    public GameWispAnniversaryEvent(String username, int months, int tier) {
        this.username = username;
        this.months = months;
        this.tier = tier;
    }

    public GameWispAnniversaryEvent(String username, int months, int tier, Channel channel) {
        super(channel);
        this.username = username;
        this.months = months;
        this.tier = tier;
    }

    public String getUsername() {
        return username;
    }

    public int getMonths() {
        return months;
    }
    
    public int getTier() {
        return tier;
    }
}
