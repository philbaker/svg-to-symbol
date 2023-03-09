# SVG to Symbol
Takes an SVG file, optimises it via SVGO and prints to stdout

## Usage
Install globally with `npm -g svg-to-symbol` 

or run via npx: `npx svg-to-symbol glasses.svg glasses-outline`

- Arg 1: file name `<file.svg>`
- Arg 2 (optional): symbol id `<symbol-id>`

### Optimize SVG only (one arg)
`svg-to-symbol file.svg`

### Optimize SVG and return path wrapped in symbol (two args)
`svg-to-symbol file.svg symbol-id`

### Pipe output to clipboard
 - Ubuntu: `svg-to-symbol file.svg symbol-id | xclip -sel clip`
 - Mac: `svg-to-symbol file.svg symbol-id | pbcopy`

