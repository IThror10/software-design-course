package org.example.command.embedded;

import org.example.command.EmbeddedCommand;
import org.example.command.EnvironmentVariable;
import org.example.execution.context.Context;
import org.example.execution.exception.ExecutionException;
import org.example.interfaces.IExecutor;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.List;

public class LsCommand extends EmbeddedCommand {
    public LsCommand(List<String> commandLineArguments, List<EnvironmentVariable> environmentVariables) {
        super("ls", commandLineArguments, environmentVariables);
    }

    @Override
    public int run(IExecutor executor, Context context) throws ExecutionException {
        try {
            for (File file : new File(context.getWorkingDirectory().toAbsolutePath().toString()).listFiles())
                context.getDescriptors().stdout.print(file.getName() + " ");
            context.getDescriptors().stdout.println("");
        } catch (IOException e) {
            return 1;
        }
        return 0;
    }
}
