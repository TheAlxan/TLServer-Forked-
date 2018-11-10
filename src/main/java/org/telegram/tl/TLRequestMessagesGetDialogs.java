package org.telegram.tl;

import org.telegram.core.TLContext;
import org.telegram.tl.messages.TLDialogs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.telegram.tl.StreamUtils.*;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesGetDialogs extends TLMethod2<TLDialogs> {

    public static final int CONSTRUCTOR_ID = 0x191ba9c5;
    public static final int ID = 0x191ba9c5;

    protected int flags;

    protected boolean excludePinned;

    protected int offsetDate;

    protected int offsetId;

    protected TLInputPeer offsetPeer;

    protected int limit;

    private final String _constructor = "messages.getDialogs#191ba9c5";

    public TLRequestMessagesGetDialogs() {
    }

    public TLRequestMessagesGetDialogs(boolean excludePinned, int offsetDate, int offsetId, TLInputPeer offsetPeer, int limit) {
        this.excludePinned = excludePinned;
        this.offsetDate = offsetDate;
        this.offsetId = offsetId;
        this.offsetPeer = offsetPeer;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLDialogs deserializeResponse(InputStream stream, TLContext context) throws Exception {
        final TLObject response = readTLObject(stream, context,TLObject.class,-1);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLDialogs)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLDialogs) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = excludePinned ? (flags | 1) : (flags & ~1);
    }

    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(offsetDate, stream);
        writeInt(offsetId, stream);
        writeTLObject(offsetPeer, stream);
        writeInt(limit, stream);
    }

    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws Exception {
        flags = readInt(stream);
        excludePinned = (flags & 1) != 0;
        offsetDate = readInt(stream);
        offsetId = readInt(stream);
        offsetPeer = readTLObject(stream, context, TLInputPeer.class, -1);
        limit = readInt(stream);
    }


    public boolean getExcludePinned() {
        return excludePinned;
    }

    public void setExcludePinned(boolean excludePinned) {
        this.excludePinned = excludePinned;
    }

    public int getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(int offsetDate) {
        this.offsetDate = offsetDate;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int offsetId) {
        this.offsetId = offsetId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public int getConstructor() {
        return 0;
    }
}
