/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl.L57.messages;

import org.telegram.core.TLContext;
import org.telegram.core.TLMethod;
import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLStickerSetCovered;
import org.telegram.tl.TLVector;

public class GetFeaturedStickers extends TLObject implements TLMethod {

    public static final int ID = 0x2dacca4f;

    public int hash;

    public GetFeaturedStickers() {
    }

    public GetFeaturedStickers(int hash) {
        this.hash = hash;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        hash = buffer.readInt();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(8);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(hash);
    }


    public int getConstructor() {
        return ID;
    }

    @Override
    public TLObject execute(TLContext context, long messageId, long reqMessageId) {
        return new FeaturedStickers(0, new TLVector<TLStickerSetCovered>(), new TLVector<Long>());
    }
}