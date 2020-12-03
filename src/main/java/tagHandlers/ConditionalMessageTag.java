package tagHandlers;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class ConditionalMessageTag extends SimpleTagSupport {
    private String expected;
    private String actual;
    private String message;

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void doTag() throws IOException {
        if (expected.equals(actual)) {
            getJspContext().getOut().println(message);
        }
    }
}
