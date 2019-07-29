let chai = require('chai');
let assert = chai.assert;
let isBalanced = require("../interview_questions/arrays/BalancedBrackets").isBalanced;

describe('Balanced Brackets', function() {
    it("isBalanced returns YES or NO if string is balanced brackets", function() {
        assert.equal("YES", isBalanced("{[()]}"));
        assert.equal("NO", isBalanced("{[(])}"));
        assert.equal("YES", isBalanced("{{[[(())]]}}"));
    });
});