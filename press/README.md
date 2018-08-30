# ekspress

~~Express.jsを参考に、すべてをKotlinで書くというプロジェクト。~~
~~ただ、Koa.jsのasync/await前提の作りもかっこいいので、最終的にはco-routine前提にしていきたい。~~

紆余曲折あって、もとのExpress.jsとは、全く別物になった Web Application Framework。

Express.jsのミドルウェアという考え方をもとに、Koa.jsのコンテクストという導入した。
コンテクストは、不変オブジェクトで、ミドルウェアは、渡されたコンテクストから、新しいコンテクストを返す。
その循環によって、アプリケーションを構築する。