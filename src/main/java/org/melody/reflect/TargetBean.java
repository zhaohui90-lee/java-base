package org.melody.reflect;

/**
 * @author lizhaohui
 * @since 2023/2/9
 */
public final class TargetBean {
    private String name;
    private int version;
    public String getName() {
        return name;
    }
    public void setName(String name) {
    this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
