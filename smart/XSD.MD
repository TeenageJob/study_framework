<!--tyd文件本身是xml文件，第一行是xml声明 -->
<ty:schema xmlns="http://www.tianyuan.org/schema/ok" 
	xmlns:ty="http://www.w3.org/2001/XMLSchema"
	targetNamespace="http://www.tianyuan.org/schema/ok" 
	elementFormDefault="qualified">
	<!-- 
	tyd作为xml文件，其根元素是schema 属性xmlns:ty="http://www.w3.org/2001/XMLSchema" 
		是引入文档约束的，表示在当前文档导入"http://www.w3.org/2001/XMLSchema"中所描述的规则，
		 并且使用里面的元素要添加tyd的前缀（和xmlns:tyd相对应，也可以指定其它前缀） 
	属性targetNamespace="http://www.tianyuan.org/schema/ok" 
		表示当前文档定义的规则处于命名空间"http://www.tianyuan.org/schema/ok"下面， 
		xml文档如需要导入当前文档的规则，就可以指定这个命名空间 
	属性xmlns="http://www.tianyuan.org/schema/ok" 
		表示在当前文档中导入"http://www.tianyuan.org/schema/ok"
		 命名空间下所描述的规则（即当前文档本身描述的规则），并且无需使用前缀，也即默认命名空间， 
		这样，在当前文档就可以直接引用所定义的元素了
	属性 elementFormDefault="qualified" 
		指出任何 XML 实例文档所使用的且在此 schema 中声明过的元素必须被命名空间限定。 -->

元素	解释
all	规定子元素能够以任意顺序出现，每个子元素可出现零次或一次。
annotation	annotation 元素是一个顶层元素，规定 schema 的注释。
any	使创作者可以通过未被 schema 规定的元素来扩展 XML 文档。
anyAttribute	使创作者可以通过未被 schema 规定的属性来扩展 XML 文档。
appInfo	规定 annotation 元素中应用程序要使用的信息。
attribute	定义一个属性。
attributeGroup	定义在复杂类型定义中使用的属性组。
choice	仅允许在 <choice> 声明中包含一个元素出现在包含元素中。
complexContent	定义对复杂类型（包含混合内容或仅包含元素）的扩展或限制。
complexType	定义复杂类型。
documentation	定义 schema 中的文本注释。
element	定义元素。
extension	扩展已有的 simpleType 或 complexType 元素。
field	规定 XPath 表达式，该表达式规定用于定义标识约束的值。
group	定义在复杂类型定义中使用的元素组。
import	向一个文档添加带有不同目标命名空间的多个 schema。
include	向一个文档添加带有相同目标命名空间的多个 schema。
key	指定属性或元素值（或一组值）必须是指定范围内的键。
keyref	规定属性或元素值（或一组值）对应指定的 key 或 unique 元素的值。
list	把简单类型定义为指定数据类型的值的一个列表。
notation	描述 XML 文档中非 XML 数据的格式。
redefine	重新定义从外部架构文件中获取的简单和复杂类型、组和属性组。
restriction	定义对 simpleType、simpleContent 或 complexContent 的约束。
schema	定义 schema 的根元素。
selector	指定 XPath 表达式，该表达式为标识约束选择一组元素。
sequence	要求子元素必须按顺序出现。每个子元素可出现 0 到任意次数。
simpleContent	包含对 complexType 元素的扩展或限制且不包含任何元素。
simpleType	定义一个简单类型，规定约束以及关于属性或仅含文本的元素的值的信息。
union	定义多个 simpleType 定义的集合。
unique	指定属性或元素值（或者属性或元素值的组合）在指定范围内必须是唯一的。

type： 
ty:boolean 
ty:anyURI 如果某个 URI 含有空格，请用 %20 替换它们
ty:hexBinary:二进制
ty:decimal
ty:integer
名字	秒数
byte	有正负的 8 位整数
decimal	十进制数
int	有正负的 32 位整数
integer	整数值
long	有正负的 64 位整数
negativeInteger	仅包含负值的整数 ( .., -2, -1.)
nonNegativeInteger	仅包含非负值的整数 (0, 1, 2, ..)
nonPositiveInteger	仅包含非正值的整数 (.., -2, -1, 0)
positiveInteger	仅包含正值的整数 (1, 2, ..)
short	有正负的 16 位整数
unsignedLong	无正负的 64 位整数
unsignedInt	无正负的 32 位整数
unsignedShort	无正负的 16 位整数
unsignedByte	无正负的 8 位整数


ty:date
ty:time
名称	描述
date	定义一个日期值
dateTime	定义一个日期和时间值
duration	定义一个时间间隔
gDay	定义日期的一个部分 - 天 (DD)
gMonth	定义日期的一个部分 - 月 (MM)
gMonthDay	定义日期的一个部分 - 月和天 (MM-DD)
gYear	定义日期的一个部分 - 年 (YYYY)
gYearMonth	定义日期的一个部分 - 年和月 (YYYY-MM)
time	定义一个时间值

ty:string
名称	描述
ENTITIES	 
ENTITY	 
ID	在 XML 中提交 ID 属性的字符串 (仅与 schema 属性一同使用)
IDREF	在 XML 中提交 IDREF 属性的字符串(仅与 schema 属性一同使用)
IDREFS language	包含合法的语言 id 的字符串
Name	包含合法 XML 名称的字符串
NCName	 
NMTOKEN	在 XML 中提交 NMTOKEN 属性的字符串 (仅与 schema 属性一同使用)
NMTOKENS	 
normalizedString	不包含换行符、回车或制表符的字符串
QName	 
string	字符串
token	不包含换行符、回车或制表符、开头或结尾空格或者多个连续空格的字符串





限定	描述
enumeration	定义可接受值的一个列表
fractionDigits	定义所允许的最大的小数位数。必须大于等于0。
length	定义所允许的字符或者列表项目的精确数目。必须大于或等于0。
maxExclusive	定义数值的上限。所允许的值必须小于此值。
maxInclusive	定义数值的上限。所允许的值必须小于或等于此值。
maxLength	定义所允许的字符或者列表项目的最大数目。必须大于或等于0。
minExclusive	定义数值的下限。所允许的值必需大于此值。
minInclusive	定义数值的下限。所允许的值必需大于或等于此值。
minLength	定义所允许的字符或者列表项目的最小数目。必须大于或等于0。
pattern	定义可接受的字符的精确序列。
totalDigits	定义所允许的阿拉伯数字的精确位数。必须大于0。
whiteSpace	定义空白字符（换行、回车、空格以及制表符）的处理方式。


Order 指示器：
	All 指示器规定子元素可以按照任意顺序出现
	Choice 指示器规定可出现某个子元素或者可出现另外一个子元素（非此即彼）
	Sequence 规定子元素必须按照特定的顺序出现
Occurrence 指示器： 指示器用于定义某个元素出现的频率。
	maxOccurs 指示器可规定某个元素可出现的最大次数
	minOccurs 指示器可规定某个元素能够出现的最小次数
Group 指示器：指示器用于定义相关的数批元素
	Group name 元素组
	attributeGroup name 属性组
	
Any 扩展其他tyd内容
anyAttribute 扩展其他tyd属性

替换元素：紧挨原元素
<ty:element name="要替换的名" substitutionGroup="newName">

阻止替换 属性：block="substitution"