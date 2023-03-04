# SVG to Symbol
Takes an SVG file, optimises it via SVGO and prints `<symbol><path /></symbol>` to stdout

## Example
`nbb svg_to_symbol.cljs glasses.svg glasses-outline`

- Arg 1: file name `<file.svg>`
- Arg 2: symbol id `<symbol-id>`

Pipe output to clipboard (Ubuntu): `nbb svg_to_symbol.cljs glasses.svg glasses-outline | xclip -sel clip`
