package org.example.interfaces;

import org.example.command.Command;
import org.example.execution.context.Context;
import org.example.execution.exception.ExecutionException;
import org.example.substitution.Substitutor;

public interface IExecutor extends IEmbeddedExecutor {

    ISubstitutor getSubstitutor();

    IParser getParser();

}
