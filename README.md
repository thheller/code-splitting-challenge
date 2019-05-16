# Code Splitting ClojureScript

This is a slightly modified [Code Splitting ClojureScript](https://code.thheller.com/blog/shadow-cljs/2019/03/03/code-splitting-clojurescript.html) example meant to demonstrate a "common" code-splitting scenario where a couple modules exist and each may depend on others.

In this scenario the `:product-detail` module/chunk depends on the `:product-listing` which in turn depends on `:main`. `:product-detail` has a dependency on `react-select` and a shared dependency on `react-table` which `:product-listing` also uses. These are just examples and the packages aren't actually used in the code. The point is that `react-table` should be loaded as part of the `:product-listing` package and `react-select` as part of `:product-listing`.

## Want a Challenge?

When initially building the `npm` intergration for `shadow-cljs` based on `webpack` this was scenario that provided the most difficulty. This is not a theoretical scenario, it was taken out of an actual app (although with different packages). I'm sure this is possible somehow and might have gotten easier with newer `webpack` versions but I was not able to get this running properly where things were chunked in an accurate fashion. The goal is to keep as much code as possible out of the `:main` module since that will always be loaded first.

The example code is still kind of tiny but demonstrates well why code-splitting is especially important when adding 3rd party npm libraries (ie. `react-select` adds over 112kb on its own, not including the other dependencies it brings with it).

I'd be extremely curious to see a solution that achieves a similar split using `webpack` + CLJS.

## Building

You can compile it by cloning the repo and running

```
npm install
npx shadow-cljs watch app
;; or
npx shadow-cljs release app

;; generate a build report via
npx shadow-cljs run shadow.cljs.build-report app report.html

;; then open report.html in the browser
```

and then open http://localhost:8000.

The demo is hosted here:
- https://code.thheller.com/demos/code-splitting-challenge/

The sample build report is available here:
- https://code.thheller.com/demos/code-splitting-challenge/report.html