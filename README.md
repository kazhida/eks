# eks

Web framework on node.js of Kotlin by Kotlin for Kotlin.

Inspired from express.js and koa.js.

## 動機

これからは、Node.jsとGraphQLがくると思っているのだけど、即、仕事で使うかといったら、どうなんだろうという感じで、今ひとつ本気になれないでいた。もともとアプリの人で、サーバの人じゃないし。

とはいえ、なにも手を出さないのはリスク（相対的後退）があるので、自分個人のプロジェクトとして、始めようと考えた。

その一方で、Androidアプリの開発以外でもKotlinを使いたい（すべての分野にあまねくKotlinを）こともあって、

* Express.jsと同じようなものをKotlinで再実装してみる（[ekspress](./press/README.md)）
* その上で、ミドルウェアとして、GraphQLを使うためのなにかを作る（[eksgraph](./graph/README.md)）
* 必要そうなミドルウェアを用意する（[ekstension](./tension/README.md)）
* ~~あわよくば、フルスタックなフレームワークまでいっちゃおう（[eksmachina](./machina/README.md)）~~
* npmやwebpackを直に触らなくてもすむようなGradleプラグインを作る必要があるな（[eksmachina](./machina/README.md)）

という壮大なプロジェクトを始めた。

## ゴール

とにかく、GraphQLを使ったAPIサーバまでは作りたい。

その上で、フルスタック・フレームワークに成長させたい。

## 開発体制

僕個人が、通勤時間を使って、開発しているので、圧倒的に時間が足りない。

しかし、何かしら制限を入れないと、これにかかりきりになってしまって、社会的にまずいことになりかねないので、この制限は原則として持っておく。
ちなみに、今はこれに集中するために、例年と異なり夏休みをとって開発を進めている（2018/8/9:現在）。