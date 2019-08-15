/*
Create a function that, given a DOM Element on the page, will visit the element
itself and all of its descendents (not just its immediate children). For each element
visited, the function should pass that element to a provided callback function.
 */

function depthFirstSearch(element, callback) {
    callback(element);
    let list = element.children;

    for (let i = 0; i < list.length; i++) {
        depthFirstSearch(list[i], callback);
    }
}