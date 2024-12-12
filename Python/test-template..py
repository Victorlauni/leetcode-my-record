import unittest
from importlib import import_module

class MyTestCase(unittest.TestCase):
    def test_something(self):
        module = import_module('106-construct-binary-tree-from-inorder-and-postorder-traversal')
        solution = module.Solution()
        result = solution.buildTree([1,2,3], [3,2,1])
        print(result)


if __name__ == '__main__':
    unittest.main()
