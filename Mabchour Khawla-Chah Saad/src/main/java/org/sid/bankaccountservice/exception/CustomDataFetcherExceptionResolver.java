package org.sid.bankaccountservice.exception;

import graphql.ErrorClassification;
import graphql.GraphQL;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import reactor.core.publisher.Mono;

import java.util.List;

public class CustomDataFetcherExceptionResolver extends DataFetcherExceptionResolverAdapter {
    @Override
   protected GraphQLError resolveToSingleError(Throwable ex,DataFetchingEnvironment env){
        return new GraphQLError() {
            @Override
            public String getMessage() {
                return ex.getMessage();
            }

            @Override
            public List<SourceLocation> getLocations() {
                return null;
            }

            @Override
            public ErrorClassification getErrorType() {
                return null;
            }
        };
    }
}
