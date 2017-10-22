package com.bawei.monthrepeat1.Utils.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import static com.squareup.okhttp.internal.Internal.logger;

class LoggingInterceptor implements Interceptor {
  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();


    long t1 = System.nanoTime();
logger.info(String.format("Sending request %s on %s%n%s", request.url(),
chain.connection(), request.headers()));


    Response response = chain.proceed(request);
    long t2 = System.nanoTime();
    logger.info(String.format("Received response for %s in %.1fms%n%s",
        response.request().url(), (t2 - t1) / 1e6d, response.headers()));

    return response;
  }
}