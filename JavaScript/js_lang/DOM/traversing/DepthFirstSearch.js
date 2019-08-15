const depthFirstSearch = (node, layer) => {
    const stack = Array.from(node);

    while (stack.length) {
        const root = stack.shift();
        printInfo(root, layer);

        if (root.children.length) {
            depthFirstSearch(root.children, layer + 1)
        }
    }
};

const BFSTraverse = (rootNodes, rootLayer) => {
    const roots = Array.from(rootNodes)
    const rootsLayer = [] // Store the hierarchy of each node in a single array
    // Initialization
    for (let i = 0; i < roots.length; i++) {
        rootsLayer.push(rootLayer)
    }
    var rootIdx = 0 // Record the number of nodes in the current processing roots to facilitate finding the corresponding levels in rootsLayer
    while (roots.length) {
        const root = roots.shift() // Team out
        printInfo(root, rootsLayer[rootIdx])
        // If there are children, place them in the roots queue
        if (root.children.length) {
            Array.prototype.push.apply(roots, Array.from(root.children))
            // Add the current level to 1 to get the level of the child node
            rootLayer = rootsLayer[rootIdx] + 1
            for (let i = 0; i < root.children.length; i++) {
                rootsLayer.push(rootLayer)
            }
        }
        // Processing the next root node
        rootIdx++
    }
}


const printInfo = (node, layer) => {
    let str = '';
    for (let i = 0; i < layer; i++) {
        str += ' ';
    }
    console.log(`${layer}:${str}${node.tagName} .${node.id}`);
};

const findNodeByIdDFS = (node, id) => {
    const stack = Array.from(node);

    while (stack.length) {
        const root = stack.shift();

        if (root.id !== null && root.id === id) {
            return root;
        }

        if (root.children.length) {
            findNodeByIdDFS(root.children, id);
        }
    }
};


let main = document.getElementById("main");

let node = findNodeByIdDFS(main.children, "article-2");
console.log(node);
