package tagHandlers;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ConditionalMessageTag extends SimpleTagSupport {
    private boolean condition;
    private String message;

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void doTag() throws IOException {
        if (condition) {
            getJspContext().getOut().println(message);
        }
    }
}
