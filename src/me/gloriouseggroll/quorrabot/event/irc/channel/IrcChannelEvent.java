/* 
 * Copyright (C) 2015 www.quorrabot.com
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
package me.gloriouseggroll.quorrabot.event.irc.channel;

import me.gloriouseggroll.quorrabot.event.irc.IrcEvent;
import me.gloriouseggroll.quorrabot.jerklib.Channel;
import me.gloriouseggroll.quorrabot.jerklib.Session;

public class IrcChannelEvent extends IrcEvent
{

    private final Channel channel;

    protected IrcChannelEvent(Session session, Channel channel)
    {
        super(session);
        this.channel = channel;
    }

    public Channel getChannel()
    {
        return channel;
    }
}