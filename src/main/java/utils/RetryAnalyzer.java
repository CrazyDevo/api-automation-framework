package utils;

import org.junit.jupiter.api.extension.*;

public class RetryAnalyzer implements TestExecutionExceptionHandler {

    private static final int MAX_RETRY = 2;

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        int retries = context.getStore(ExtensionContext.Namespace.GLOBAL)
                .getOrDefault("retries", Integer.class, 0);

        if (retries < MAX_RETRY) {
            context.getStore(ExtensionContext.Namespace.GLOBAL)
                    .put("retries", retries + 1);
        } else {
            throw throwable;
        }
    }
}