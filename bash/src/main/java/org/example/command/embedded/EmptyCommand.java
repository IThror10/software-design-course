package org.example.command.embedded;

import org.example.command.EmbeddedCommand;
import org.example.command.EnvironmentVariable;
import org.example.execution.context.Context;
import org.example.execution.exception.ExecutionException;
import org.example.interfaces.IExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EmptyCommand extends EmbeddedCommand {

    @Override
    public int run(IExecutor executor, Context context) throws ExecutionException {
        return 0;
    }

    public EmptyCommand(List<String> commandLineArguments, List<EnvironmentVariable> environmentVariables) {
        super("", commandLineArguments, environmentVariables);
    }
}

