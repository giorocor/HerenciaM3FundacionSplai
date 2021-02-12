![banerGit](https://user-images.githubusercontent.com/22893383/107159880-121e0b80-6993-11eb-92e3-1efd1d8f4dba.PNG)

# Proyecto Grupal: Taller de Vehículos 

#### 1. Equipo Desarrollo 

| Developer | Rama | Rol | Fecha Incorporación | Proyecto |
| --- | :---:  | :---:  | :---:  | :---: |
| Miguel Á. Sastre | Master / Miguel-Á.-Sastre | Project Manager/Dev | 11/02/2021 | M3 |
| Cristián Rivas | crivas |  Developer| 11/02/2021 | M3 |
| Albert Diaz | Smulli |  Developer| 11/02/2021 | M3 |   
| Giovanni Rodriguez | giorocor|  Developer| 11/02/2021 | M3 |

#### 2. Descripción
```
Ejercicío en grupo para el curso FS Java+Angular+SQL de la Fundanción Esplai.
```

##### Enunciado de la actividad
```
Volem fer un software per un taller de vehicles, que en aquest moment té motos i cotxes. Els cotxes sempre tindran quatre rodes i les motos dues.
```
###### MILESTONE 1
```
	FASE 1:
		S’ha de crear un projecte, C# de consola, amb les funcionalitats demanades per tal que el software funcione correctament.
		Ens demanen crear un metode Main que realitzi els següents passos:
			1) Demanar a l’usuari la matrícula del cotxe, la marca i el seu color.
			2) Crear el cotxe amb les dades anteriors.
			3) Afegir-li dues rodes traseres demanant a l’usuari la marca i el diametre.
			4) Afegir-li dues rodes davanteres demanant a l’usuari la marca i el diametre.
	FASE 2:
		Millorar el codi anterior comprovant la informació necesaria alhora de crear els objectes. S’ha de tenir en
		compte:
			1) Una matrícula ha de tenir 4 números i dues o tres lletres.
			2) Un diametre de la roda ha de ser superior a 0.4 i inferior a 4
	FASE 3:
		Modifica el projecte anterior afegint els mètodes necessaris a Bike, de manera que es pugui afegir rodes davanteres i traseres.
		Modificar el Main anterior, afegint la opció de Bike o Car:
			0) Preguntar a l’usuari si vol crear un cotxe o una moto.
			1) Demanar a l’usuari la matrícula, la marca i el seu color.
			2) Crear el vehícle amb les dades anteriors.
			3) Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre.
			4) Afegir-li les rodes davanteres corresponents, demanant a l’usuari la marca i el diametre.

```

###### MILESTONE 2

```
	FASE 1:
		Modifica l’exercici per afegir camió com a vehicle disponible.
	FASE 2:
		Crea dos classes: Titular de Vehicle i Conductor (també fes una classe Persona com a herència). El conductor ha de tenir, nom, cognoms, data de naixement i llicencia de conduir. Aquest ultima també serà una classe a part que tindrà: ID, tipus de llicència, nom complet i data de caducitat. El Titular ha de tenir els mateixos valors que el conductor, però també s'ha de registrar si té assegurança i garatge propi.
	FASE 3:
		Abans de seleccionar el vehicle has de crear l'usuari (tipus Titular) amb totes les dades ja emplenades.
		Per poder crear un vehicle has de tenir la llicència adequada, de no tenir-la t'ha d'avisar amb una excepció.
		A l'acabar de crear el vehicle, ha de demanar si el titular també serà el conductor. De no ser així has de crear un nou usuari. En fer-ho hi ha de comprovar si la llicència del conductor li permet conduir el vehicle creat.
```

###### MILESTONE 3

```
En aquesta fase modificaràs l’exercici per que es registri la quantitat de Persones y vehicles que es creen. L’aplicació ha d’acabar nomes quan s’indiqui que s’acabi, per tan pots crear tants vehicles i persones com vulguis. Has de tenir 2 menus separats, un per crear usuaris i un altre per crear vehicles.

FASE 1:
	Modifica el main per tenir la llista de persones i vehicles.
	Modifica la clase vehicle, afegeix dos camps, un camp tipus Titular per assignar-li un titular al vehicle i una llista de Persones (que seran els conductors, el titular pot ser conductor).
	Al crear un vehicle s'ha d'assignar un titular al vehicle i donar la possibilitat d'afegir conductors. Tots ells han de tenir la llicència adequada.
	Has de poder crear múltiples persones (conductors o titulars) i múltiples vehicles fins que decideixis acabar el programa.
```
