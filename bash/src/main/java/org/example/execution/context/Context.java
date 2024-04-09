package org.example.execution.context;

import lombok.Getter;
import lombok.Setter;
import org.example.execution.descriptor.AbstractDescriptor;
import org.example.execution.descriptor.DescriptorSet;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Interpreter context in which command is evaluated
 */
@Getter
@Setter
public class Context {
    private final Environment environment;
    private Path workingDirectory;
    private final DescriptorSet descriptors;

    public Environment getEnvironment() {
        return environment;
    }

    public Path getWorkingDirectory() {
        return workingDirectory;
    }

    public DescriptorSet getDescriptors() {
        return descriptors;
    }

    public Context() {
        this(new Environment(), Paths.get("").toAbsolutePath(), new DescriptorSet());
    }

    private Context(Environment environment, Path workingDirectory, DescriptorSet descriptors) {
        this.environment = environment;
        this.workingDirectory = workingDirectory;
        this.descriptors = descriptors;
    }

    public Context forkEnvironment(Environment environment) {
        return new Context(environment, this.workingDirectory, this.descriptors);
    }

    public Context forkWorkingDirectory(Path workingDirectory) {
        return new Context(this.environment, workingDirectory, this.descriptors);
    }

    public Context forkDescriptors(DescriptorSet descriptors) {
        return new Context(this.environment, this.workingDirectory, descriptors);
    }

    public Context forkStdin(AbstractDescriptor descriptor) {
        return forkDescriptors(this.getDescriptors().forkStdin(descriptor));
    }

    public Context forkStdout(AbstractDescriptor descriptor) {
        return forkDescriptors(this.getDescriptors().forkStdout(descriptor));
    }

    public Context forkStderr(AbstractDescriptor descriptor) {
        return forkDescriptors(this.getDescriptors().forkStderr(descriptor));
    }

    public Context forkOutput(AbstractDescriptor descriptor) {
        return forkStdout(descriptor).forkStderr(descriptor);
    }

}
