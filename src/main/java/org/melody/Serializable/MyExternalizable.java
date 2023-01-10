package org.melody.Serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 自定义协议
 * @author lizhaohui
 * @since 2023/1/10
 */
public class MyExternalizable implements Externalizable {

    private static final long serialVersionUID = -91488883661953146L;

    public byte[] bytes;

    public MyExternalizable() {

    }

    public MyExternalizable(byte[] b) {
        this.bytes = b;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(bytes.length);
        out.write(bytes);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int len = in.readInt();
        bytes = new byte[len];
        in.readFully(bytes, 0, len);
    }
}
