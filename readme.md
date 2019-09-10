# CQRS/ES with Apache Spark as Query model

- Service receives events/commands via/from Kafka
- Akka persistence used to persist events/commands
- Use Apache Spark to generate CQRS - Query/views of events
- Service A
  - Play framework REST API receives (UI) command/action (Play REST acts as Port/Adapter in Hexagonal arch)
  - Akka actor (persistance) receives command
  - Akka actor process command and fire event (that command is processed) and writes to Kafka (if possible use persistance with Kafka)
  - Service creates (Q)uery model based on events in journal (available in Kafka)
- Service B
  - Listens to events fired from Service A on Kafka topic
- Add Gatling Load tests
- Add JMeter load tests ( and compare with JMeter)

## Sprint 1
