import unittest
from importlib import import_module

class MyTestCase(unittest.TestCase):
    def test_something(self):
        module = import_module('27-remove-element')
        solution = module.Solution()
        solution.removeElement([3,2,2,3], 3)


if __name__ == '__main__':
    unittest.main()
