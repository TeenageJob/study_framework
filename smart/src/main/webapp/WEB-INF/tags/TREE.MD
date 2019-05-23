参数名称	参数类型	参数描述
text	String(必选项)	列表树节点上的文本，通常是节点右边的小图标。
icon	String(可选项)	列表树节点上的图标，通常是节点左边的图标。
selectedIcon	String(可选项)	当某个节点被选择后显示的图标，通常是节点左边的图标。
href	String(可选项)	结合全局enableLinks选项为列表树节点指定URL。
selectable	Boolean. Default: true	指定列表树的节点是否可选择。设置为false将使节点展开，并且不能被选择。
state	Object(可选项)	一个节点的初始状态。
state.checked	Boolean，默认值false	指示一个节点是否处于checked状态，用一个checkbox图标表示。
state.disabled	Boolean，默认值false	指示一个节点是否处于disabled状态。（不是selectable，expandable或checkable）
state.expanded	Boolean，默认值false	指示一个节点是否处于展开状态。
state.selected	Boolean，默认值false	指示一个节点是否可以被选择。
color	String. Optional	节点的前景色，覆盖全局的前景色选项。
backColor	String. Optional	节点的背景色，覆盖全局的背景色选项。
tags	Array of Strings. Optional	通过结合全局showTags选项来在列表树节点的右边添加额外的信息。


结构：
var tree = [
  {
    text: "Parent 1",
    nodes: [
      {
        text: "Child 1",
        nodes: [
          {
            text: "Grandchild 1"
          },
          {
            text: "Grandchild 2"
          }
        ]
      },
      {
        text: "Child 2"
      }
    ]
  },
  {
    text: "Parent 2"
  },
  {
    text: "Parent 3"
  },
  {
    text: "Parent 4"
  },
  {
    text: "Parent 5"
  }
];