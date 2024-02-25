package org.example.command.embedded;

import org.example.command.EmbeddedCommand;
import org.example.command.EnvironmentVariable;
import org.example.execution.context.Context;
import org.example.execution.exception.ExecutionException;
import org.example.interfaces.IExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CatCommand extends EmbeddedCommand {

    @Override
    public int run(IExecutor executor, Context context) throws ExecutionException {
        try {
            String filePath = getCommandLineArguments().get(0);
            Path path = Path.of(filePath);

            if (!path.isAbsolute()) {
                path = context.getWorkingDirectory().resolve(path);
            }

            if (!Files.exists(path)) {
                throw new ExecutionException("File does not exist: " + path);
            }

            String content = new String(Files.readAllBytes(path));
            context.getDescriptors().stdout.print(content);

        } catch (IOException e) {
            return 1;
        }

        return 0;
    }

    public CatCommand(List<String> commandLineArguments, List<EnvironmentVariable> environmentVariables) {
        super("cat", commandLineArguments, environmentVariables);
    }
}