数据库缓存：memcache redis ehcache
	针对数据库的增、删、查、改，数据库缓存技术应用场景绝大部分针对的是“查”的场景。
	数据弱一直性
	有持久化需求或者对数据结构和处理有高级要求的应用，选择redis。其他简单的key/value存储，选择memcache。
静态缓存：
	静态缓存技术，CDN是经典代表之作。静态缓存技术面非常广，涉及的开源技术包含apache、Lighttpd、nginx、varnish、squid等
	静态缓存，一般指 web 类应用中，将图片、js、css、视频、html等静态文件/资源通过磁盘/内存等缓存方式，提高资源响应方式，减少服务器压力/资源开销的一门缓存技术。
	浏览器缓存：
		expires 来缓存一些内容到访问者浏览器
	磁盘缓存：
		单纯围绕 nginx 的 squid、varnish 等一类中间件，处理静态数据的性能十分优秀
	Nginx 的内存缓存
	CDN(典型)：
动态缓存：
	


1:memcached
	简介：协议简单、基于libevent的事件处理、内置内存存储方式、memcached不互相通信的分布式。 各个memcached不会互相通信以共享信息，分布策略由客户端实现。不会对数据进行持久化，重启memcached、重启操作系统会导致全部数据消失
	应用场景：常见的应用场景是存储一些读取频繁但更新较少的数据，如静态网页、系统配置及规则数据、活跃用户的基本数据和个性化定制数据、准实时统计信息等
2：HBase
	列存储 
	HBase是非结构化数据存储,就是说是基于列的而不是基于行的模式。HBase是介于Map Entry(key & value)和DB Row之间的一种数据存储方式。就点有点类似于Memcache，但不仅仅是简单的一个key对应一个 value，你很可能需要存储多个属性的数据结构，但没有传统数据库表中那么多的关联关系，这就是所谓的松散数据。
3:redis：


4：ehcache：
	配置详解：
	<!-- 
                            磁盘存储:将缓存中暂时不使用的对象,转移到硬盘,类似于Windows系统的虚拟内存
          path:指定在硬盘上存储对象的路径
     -->
      <diskStore path="java.io.tmpdir" />
     <!-- 
        defaultCache:默认的缓存配置信息,如果不加特殊说明,则所有对象按照此配置项处理
        maxElementsInMemory:设置了缓存的上限,最多存储多少个记录对象
        eternal:代表对象是否永不过期
        timeToIdleSeconds:最大的发呆时间
        timeToLiveSeconds:最大的存活时间
        overflowToDisk:是否允许对象被写入到磁盘
     -->
      <defaultCache 
      	maxElementsInMemory="10000" 
      	eternal="false"
        timeToIdleSeconds="120" 
        timeToLiveSeconds="120" 
        overflowToDisk="true" /> 
      <!-- 
        cache:为指定名称的对象进行缓存的特殊配置
        name:指定对象的完整名
        diskPersistent： 是否在磁盘上持久化。指重启jvm后，数据是否有效。默认为false。 
        diskExpiryThreadIntervalSeconds： 对象检测线程运行时间间隔。标识对象状态的线程多长时间运行一次。
        diskSpoolBufferSizeMB： DiskStore使用的磁盘大小，默认值30MB。每个cache使用各自的DiskStore。
        memoryStoreEvictionPolicy： 如果内存中数据超过内存限制，向磁盘缓存时的策略。默认值LRU，可选FIFO、LFU。
       	１、FIFO ，first in first out (先进先出).
　　		２、LFU ， Less Frequently Used (最少使用).意思是一直以来最少被使用的。缓存的元素有一个hit 属性，hit 值最小的将会被清出缓存。
　　		３、LRU ，Least Recently Used(最近最少使用). (ehcache 默认值).缓存的元素有一个时间戳，当缓存容量满了，而又需要腾出地方来缓存新的元素的时候，那么现有缓存元素中时间戳离当前时间最远的元素将被清出缓存。
     -->
    <cache 
	    name="com.zbaccp.entity.Person" 
	    maxElementsInMemory="10000" 
	    eternal="false"
	    timeToIdleSeconds="300" 
	    timeToLiveSeconds="600" 
	    overflowToDisk="true"
	    diskPersistent="false" />
      
   