# JustJavascript

[CSS] Basics important concepts

## [Just CSS] 01. Basics

- star \* ->> all elements

- div ->> all divs tags

- div, p ->> all divs and paragraphs

- div > p ->> all p tags, one level deep in div (Child Combinator / Direct Descendant selector, will NOT apply to grand children)

- div + p ->> p tags immediately after div (Adjacent Sibling selector, selects only the immediate sibling)

- div ~ p ->> p tags preceded with class (General Sibling selector, share the same parent and are on the same level)

- .classname ->> all elements with class

- \# idname ->> element wit ID

- div.classname ->> divs with certain class name

- div#idname ->> div with certain ID

- \# idname \* ->> all elements inside idname

~ Box Model
All HTML elements can be considered as boxes,
In CSS, the term "box model" is used when talking about design and layout. It consists of: margins, borders, padding, and the actual content.
Inner side of Box -> Content -> Padding -> Border -> Margin -> Outer side of Box

- Content - The content of the box, where text and images appear
- Padding - Clears an area around the content. The padding is transparent
- Border - A border that goes around the padding and content
- Margin - Clears an area outside the border. The margin is transparent

~ Grid Layout Module
CSS Grid Layout Module offers a grid-based layout system, with rows and columns, making it easier to design web pages without having to use floats and positioning.
Grid Elements - A grid layout consists of a parent element, with one or more child elements.

~ Flexbox Layout Module
The Flexible Box Layout Module, makes it easier to design flexible responsive layout structure without using float or positioning.
Before the Flexbox Layout module, there were four layout modes:

Block, for sections in a webpage
Inline, for text
Table, for two-dimensional table data
Positioned, for explicit position of an element
Flexbox Elements - To start using the Flexbox model, you need to first define a flex container.

```
<div class="flex-container">
  <div>1</div>
  <div>2</div>
  <div>3</div>
</div>
```

The element above represents a flex container (the blue area -> a single row) with three flex items.

~ Responsive Media Query
Media query is a CSS technique introduced in CSS3.
It uses the @media rule to include a block of CSS properties only if a certain condition is true.

```
@media only screen and (max-width: 600px) {
  body {
    background-color: lightblue;
  }
}
```

When the width of this browser window document is 600 pixels or less, the background-color is "lightblue"

~ Animations
CSS allows animation of HTML elements without using JavaScript or Flash!
The @keyframes Rule
When you specify CSS styles inside the @keyframes rule, the animation will gradually change from the current style to the new style at certain times.

```
/* The animation code */
@keyframes example {
  from {background-color: red;}
  to {background-color: yellow;}
}
/* The element to apply the animation to */
div {
  width: 100px;
  height: 100px;
  background-color: red;
  animation-name: example;
  animation-duration: 4s;
}
```

red -> yellow -> red after 4sec

rounded corner -> border-radius: 25px;
add border images -> border-image: url(border.png)
CSS pseudo-class -> class that is used to define a special state of an HTML element
This class can be used by styling an element when a user snooped over it and also it can style an HTML element when it gets the focus.

```
selector:pseudo-class {
property:value;
}
```

pseudo-elements in CSS -> feature of CSS which is used to style the given parts of an element
we can style the first letter or line of an HTML element.

```
selector::pseudo-element {
property:value;
}
```

###

position: relative, and will remain in the natural flow of the page.
position: absolute, and will NOT remain in the natural flow of the page, It will position itself according to the closest positioned ancestor.
position: fixed, and will NOT remain in the natural flow of the page, It will position itself according to the viewport, which means it always stays in the same place even if the page is scrolled.

place div at right top

```
<div id="child1">Child1: position: absolute, right: 15px, top: 70px</div>
#child1 {
  position: absolute;
  border: 1px solid red;
  top: 70px;
  right: 15px;
}
```

place div at left bottom corner fixed ->get scrolled

```
#parent4 {
  position: fixed;
  border: 1px solid blue;
  background-color: rgba(255,200,200,0.5);
  width: 300px;
  height: 100px;
  bottom: 0;
  left: 0;
  right: 0;
}
```

element with position: sticky; is positioned based on the user's scroll position.

```
div.sticky {
  position: -webkit-sticky; /* Safari */
  position: sticky;
}

```

div at center

```
.center {
  position: absolute;
  top: 50%;
  width: 100%;
  text-align: center;
  font-size: 18px;
}
```

div at top left

```
.topleft {
  position: absolute;
  top: 8px;
  left: 16px;
  font-size: 18px;
}
```

div top right

```
.topright {
  position: absolute;
  top: 8px;
  right: 16px;
  font-size: 18px;
}
```

div bottom left

```
.bottomleft {
  position: absolute;
  bottom: 8px;
  left: 16px;
  font-size: 18px;
}
```

div bottom right

```
.bottomright {
  position: absolute;
  bottom: 8px;
  right: 16px;
  font-size: 18px;
}
```

z-index: -1; -> has a z-index of -1, it will be placed behind
