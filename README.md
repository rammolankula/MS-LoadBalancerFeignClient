#### Spring Cloud-NetFlix Open Feign(Opem Feign)
#### ============================================
<pre>
&#8594; <b>Feign Client is a Declarative (or abstract) client.</b>
&#8594; <b>Programmer need not to write code(Class) for HTTP  call like LoadBalancerClient But we need to provide inputs 
like: ServiceId,Path,Inputs/Outputs, methodType..etc with one interface ans is abstract methods</b>
&#8594; <b>Open Feign | Feign Client generates one class at runtime by taking interface given by programmer. by using proxy concept</b>
&#8594; <b>In simple, we define interface and abstract methods with details,Feign Client generates
code using LoadBalancerClient(that uses Ribbon internally).</b>
&#8594;  <b>** While Defining Feign Client, make sure that serviceId,path,methodType,inputs/outputs must 
watch. InterfaceName and method name can be anything.</b>
&#8594; <b>On consumer interface,we should provide @FeignClient("ServiceId"). it will get one ServiceInstance 
from EurekaService based one less load factor.</b>
</pre>
<pre>
##### Applications And Flow
<b>1.Eureka Server</b>
<b>=================</b>
Name: FeignClientEurekaServer
Dep : Eureka Server

->At starter class @EnableEurekaServer
 =>application.properties
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

<b>2.Provider Microservice</b>
<b>=======================</b>
Name: FeignClientCartService-Provider
Dep: Eureka DisCovery Client,Spring Web,lombok

->Starter class: @EnableEurekaClient
spring.application.name=FeignClientCartService-Provider

server.port=9903

eureka.client.service-url.defaultZone=http://localhost:8761/eureka
eureka.instance.instance-id=${spring.application.name}:${random.value}

<b>3.Consumer Microservice</b>
<b>=======================</b>
Name: FeignClientPaymentService-Consumer
Dep: Eureka DisCovery Client,Spring Web,lombok

->Starter class: @EnableEurekaClient
spring.application.name=FeignClientPaymentService-Consumer
server.port=9904

eureka.client.service-url.defaultZone=http://localhost:8761/eureka
eureka.instance.instance-id=${spring.application.name}:${random.value}
</pre>
Note: there can be duplicate codes in MS applications like Model class code, consumer code ,,,etc
(Limitation of microservice)
conside userProfile is used in payment, invoice and building and biling then userprofilerestconsumer we nedd
to write in 3 places.
