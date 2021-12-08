from sun.jvm.hotspot.ui.tree.OopTreeNodeAdapter import Counter

with open("../../rsc/inputSeventhDezember.txt") as f:

    for x in f:
        value = x
        split = Counter(map(int, x.split(",")))

    print(split)