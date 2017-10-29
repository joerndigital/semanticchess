# Semantic Chess

A questions answering system for chess games.


## Prerequisite

You need:

- Docker (for the database)
- Maven


## Installing

1. Download the project

2. run Docker

3. start the database

```sh
$ cd src/main/database
$ docker-compose up
```

4. start the engine

```sh
$ mvn spring-boot:run
```

## Note

At first the program converts the file 1610-1899.pgn to ttl-files. After that it uploads these files plus a mapping file and an chess opening file to the database. That will take some time.


## Use

> You can now visit http://localhost/8080 and ask some queries.
> The database runs on http://localhost/8890.
> The sparql query editor runs on http://localhost/8890.


## Prefixes
If you want to use the sparql editor on http://localhost/8080: These prefixes are already in use.

```sh
PREFIX ex:    <http://example.com> 
PREFIX res:   <http://example.com/res/> 
PREFIX prop:  <http://example.com/prop/> 
PREFIX cres:  <http://pcai042.informatik.uni-leipzig.de/~swp13-sc/ChessOntology/Resources/> 
PREFIX cont:  <http://pcai042.informatik.uni-leipzig.de/~swp13-sc/ChessOntology#> 
PREFIX xsd:   <http://www.w3.org/2001/XMLSchema#>
```

## PGN Viewer
PgnViewerJS by [mliebelt](https://github.com/mliebelt/PgnViewerJS)

The PGN viewer is embedded by links from cdn.rawgit.com:
- https://raw.githubusercontent.com/mliebelt/PgnViewerJS/gh-pages/dist/css/pgnvjs.css
- https://cdn.rawgit.com/mliebelt/PgnViewerJS/gh-pages/dist/js/pgnvjs.js

If you want to include the files directly into the Semantic Chess project, go to [http://mliebelt.github.io/PgnViewerJS/docu/index.html](mliebelt.github.io)
and download the current version. After that insert the unzipped the directory to 
```
/semanticchess/src/main/webapp/static
```
## Credits
### Frontend:
- PgnViewerJS by [mliebelt](https://github.com/mliebelt/PgnViewerJS)
- Font Awesome by Dave Gandy - http://fontawesome.io
- [Bootstrap](http://getbootstrap.com/)
- [AngularJS](https://angularjs.org/) 
- [jQuery](https://jquery.com/)

### Backend:
- [Stanford coreNLP](https://stanfordnlp.github.io/CoreNLP/)
- [spring.io](https://spring.io/)
