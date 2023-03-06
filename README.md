# SVG to Symbol
Takes an SVG file, optimises it via SVGO and prints `<symbol><path /></symbol>` to stdout

## Usage
You can install globally with `npm -g svg-to-symbol` and then run `svg-to-symbol glasses.svg glasses-outline`

or run via npx: `npx svg-to-symbol glasses.svg glasses-outline`

- Arg 1: file name `<file.svg>`
- Arg 2: symbol id `<symbol-id>`

### Pipe output to clipboard
 - Ubuntu: `npx svg_to_symbol.cljs glasses.svg glasses-outline | xclip -sel clip`
 - Mac: `npx svg_to_symbol.cljs glasses.svg glasses-outline | pbcopy`
