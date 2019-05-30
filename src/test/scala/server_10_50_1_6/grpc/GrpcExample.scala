package server_10_50_1_6.grpc

import com.github.phisgr.gatling.grpc.Predef._
import io.grpc.ManagedChannelBuilder
import io.gatling.core.Predef.{stringToExpression => _, _}
import src.test.{GreetServiceGrpc, registerRequest}

import scala.concurrent.duration.DurationLong


class GrpcExample extends Simulation {

  val grpcConf = grpc(ManagedChannelBuilder.forAddress("localhost", 9002).usePlaintext()).shareChannel;
  val request  = registerRequest.newBuilder().setUsername("Kimura").build();
  val s = scenario("Example")
    .exec(
      grpc("registerGreet")
        .rpc(GreetServiceGrpc.METHOD_REGISTER_GREET)
        .payload(request)
    )
    .exitHereIfFailed
  setUp(
    s.inject(constantUsersPerSec(1) during (1 seconds))
  ).protocols(grpcConf)
}
