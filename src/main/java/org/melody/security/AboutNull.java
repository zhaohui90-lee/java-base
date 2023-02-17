package org.melody.security;

import java.util.Objects;

/**
 * 关于空指针检查<br/>
 * 在java1.7以后可以使用<code>Objects.requireNonNull(foo)</code>
 * @author lizhaohui
 * @since 2023/2/17
 */
public class AboutNull {

    static class Target {

        private String name;

        public Target(String name) {
            this.name = Objects.requireNonNull(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
