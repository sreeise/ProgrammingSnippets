
function depthFirstSearch(element, callback) {
    callback(element);
    let list = element.children;

    for (let i = 0; i < list.length; i++) {
        depthFirstSearch(list[i], callback);
    }
}

function print(element) {
    console.log(element);
}

let e = document.getElementById("article");
depthFirstSearch(e, print);