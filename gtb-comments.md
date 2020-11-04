### 完成度：
* 纯从功能角度看，还差个查询 groups 的接口，其它的都还行

### 测试：
* 没有测试

### 知识点：

__Details:__
+ \+ 使用构造函数注入
- \- POST 时 path 变成的单数了？
- \- 了解一下 @ResponseStatus

### 工程实践：

__Details:__
+ \+ 包结构划分合理
- \- 这个 studentList 很奇怪，每次返回 list 还要实时根据 name 生成？以后了删除功能，student 的 id 还会发生改变？
- \- 随机分组的实现不应该输入 GroupRepository，应该是 GroupService 的
- \- magic number 6
- \- 实时创建出来后，不做保存吗？后面只想查询 groups 怎么办？必须要出发分组才能做查询？
- \- 下面这三句可以提取到 Group 中去，第三句是多余的
- \- allStudent 是多余的

### 综合：


