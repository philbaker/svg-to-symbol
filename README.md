# SVG to Symbol

Takes an SVG file, optimises it via SVGO and writes `<symbol><path /><symbol>`
to `symbol-id`.svg

## Example
`nbb svg_to_symbol.cljs glasses.svg glasses-outline`

- Arg 1: file name <file.svg>
- Arg 2: symbol id <symbol-id>
