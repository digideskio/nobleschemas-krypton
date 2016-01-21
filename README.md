# Krypton

A straight-forward Java model of JSON schemas (Draft 4).

Krypton allows developers to work with JSON schemas using Java.

## Get Started

Krypton requires Java 7 or later.

### [Get from Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.hgwood.nobleschemas%22%20a%3A%22krypton%22)...

```
<dependency>
  <groupId>com.github.hgwood.nobleschemas</groupId>
  <artifactId>krypton</artifactId>
  <version>1.0.0</version>
</dependency>
```

```
group: 'com.github.hgwood.nobleschemas', name: 'krypton', version: '1.0.0'
```

### ...or build from sources

```
mvn install
```

### Usage

Use [Jackson Databind](https://github.com/FasterXML/jackson-databind/)'s
`ObjectMapper` to read the serialized JSON schema into Krypton's `Schema` class.

```java
try (InputStream schemaStream = getClass().getResourceAsStream("schema.json")) {
    return new ObjectMapper().readValue(schemaStream, Schema.class);
}
```

Krypton requires Jackson 2.7 or later.

## Specification Support

Krypton is able to deserialize all fields of all objects defined in the JSON
Schema Draft 4 specification, without known limitation. Please open an issue
if you detect any.

Please note however, that there is no validation aside from basic type
correctness. For example, Krypton does not verify that values in the `required`
property are actually the names of properties, only that they are strings.

## Technical choices

The objects defined by the spec are modeled in a simple way, without resorting
to inheritance. Think of them as maps with typed values of different types
(which is what they are in JSON). In accordance with this philosophy, all
fields are public. Builder-style setters are provided for convenience.

Furthermore, there is no coherence validation. Krypton will not complain that
a property reserved for schemas of type `string` (e.g. `minLength`) have a
value while the `type` property has the value `object`, just as JSON would not
complain.

JSON arrays are deserialized into either `List`s or `Set`s depending on the
semantic of the value in the specification. If the specification requires
the values to be unique (e.g. `required`), then it is a `Set`. Mind that this
means duplicates and order are not preserved upon deserialization.

### Type mapping

The types of the fields match the types defined in the spec with the following
mapping:

Type in spec | Type in Krypton
------------ | ----------------
string | String
integer | BigInteger
number | BigDecimal
boolean | Boolean
* | Object
T | T
[T] | List\<T\> or Set\<T\>
{T} | Map\<String, T\>
Union | Specific class

### Union types

Union types are modeled using specific classes that have as many fields as the
union supports. Those classes expose utility methods to help distinguish
between the different cases.

## Roadmap

- Correct serialization from a Krypton's `Schema` to a valid JSON schema
- Validation

## Change log

The versioning follows semantic versioning.

### 1.0.1

- fix: correct deserialization of `SimpleType`
  - The deserialized value was always `ARRAY`

### 1.0.0

- feat: 100% spec support (i.e. should deserialize any valid schema)
