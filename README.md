# CheckersRoyale

Linux/macOS
```bash
./mvnw clean javafx:run   
```

Windows
```bash
mvnw.cmd clean javafx:run
```

To do:
- Model -> .findMoves()
  - search for max captures, adding normal moves along the way
  - if encountered higher capture, .clear() and move on
- Save these moves in Controller
- View -> set listeners for pieces
- View -> highlight choosen piece
- Take moves from Controller
- Highlight appropriate tiles
- Set listeners on them
- After any event clear listeners on tiles and highlights
- If appropriate tile choosen, then .makeMove() (update moves list in Controller?)
- Update logical checkersBoard
- Update ui checkersBoard
- If this is not the end of move.route then come back to choosing piece (surrender in online mode?)
- If it is then clean listeners on pieces
- Check if the game has ended
- If not then toggle turn
- Come back to choosing piece
