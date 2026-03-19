package io.github.fengshch.mybatis.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class JavadocConfigBuilderTest {

    @Test
    void testDefaultCommentFormattersUseNonLambdaIdentityOperator() {
        JavadocConfigBuilder builder = new JavadocConfigBuilder();

        assertEquals("table", builder.getTableCommentFormat().apply("table"));
        assertEquals("column", builder.getColumnCommentFormat().apply("column"));
        assertFalse(builder.getTableCommentFormat().getClass().getName().contains("$$Lambda"));
        assertFalse(builder.getColumnCommentFormat().getClass().getName().contains("$$Lambda"));
    }
}
