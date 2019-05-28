# Mastermind

Mastermind is a code-breaking game for two
players. One player becomes the codemaker , the
other the codebreaker . The codemaker chooses a
pattern of four color code pegs (duplicates
allowed) and the codebreaker tries to guess it, in
both order and color.
Each guess is made by placing a row of color
code pegs on the decoding board. Once placed,
the codemaker provides feedback by placing from
zero to four key pegs in the small holes of the row
with the guess. A black key peg (small red in the
image) is placed for each code peg from the guess
which is correct in both color and position. A white
key peg indicates the existence of a correct color
code peg placed in the wrong position.

Example: Given a code [RED, BLUE, GREEN, RED] when the codebreaker gives a code with
[RED, GREEN, RED, YELLOW] the feedback will be: 1 black, 2 whites.

## Project requirements

We want a Rest API that simulates the role of the Masterminds codemaker, its main features
are:
### Create game (given a user request)
### Return feedback given a code guess
### Check game historic (optional, actually is a role of the board not the codemaker)

## Endpoints

### /codemaker/mocked 
Made for development test purposes only, allows the user to play vs a mocked game with all reds pegs for the codemaker side.

A example of body for the POST:
```
{
	"codeBreakerPegs":
	["pink","red","pink","blue"]
}
```
## /codemaker

Also for development test purposes, allows the user to play vs a given by himself game.

A example of the body for the POST:
```
{
  "codeMakerPegs":
	["pink","red","pink","blue"],
	"codeBreakerPegs":
	["pink","red","pink","blue"]
}
```
## /codemaker/create

Allows the user to create a new game.

A example of the body for the POST:
```
{
  "codeMakerPegs":
	["pink","red","pink","blue"]
}
```
## /codemaker/play

Allows the user to play vs the last created game

A example of the body for the POST:
```
{
	"codeBreakerPegs":
	["pink","red","pink","blue"]
}
```
