package org.example.command.embedded;

import org.example.command.EmbeddedCommand;
import org.example.command.EnvironmentVariable;
import org.example.execution.context.Context;
import org.example.execution.exception.ExecutionException;
import org.example.interfaces.IExecutor;

import java.nio.file.InvalidPathException;
import java.util.List;

public class CdCommand extends EmbeddedCommand {
    public CdCommand(List<String> commandLineArguments, List<EnvironmentVariable> environmentVariables) {
        super("cd", commandLineArguments, environmentVariables);
    }

    @Override
    public int run(IExecutor executor, Context context) throws ExecutionException {
        try {
            context.setWorkingDirectory(
                    context.getWorkingDirectory().resolve(getCommandLineArguments().get(0))
            );
        } catch (InvalidPathException e) {
            return 1;
        }
        return 0;
    }
}
