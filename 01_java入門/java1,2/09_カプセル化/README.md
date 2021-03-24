# カプセル化
`フィールドへの読み書きやメソッドの呼び出しを制御する機能`  
例えば、「このメソッドはAクラスから呼び出せるが、Bクラスからは呼び出せない」「このフィールドの内容は読めるけど、書き換えは禁止」といった表現を実現できる。このように、情報へのアクセスや動作の実施について「誰に何を許すか」を定めて制限することを`アクセス制限`という
## アクセス制御のレベル

### メンバレベル
#### 宣言方法
フィールドのアクセス制御  `アクセス修飾子　フィールド宣言;`
メソッドのアクセス制御    `アクセス修飾子　メソッド宣言{・・・}`
#### アクセス修飾子
<table style="border-collapse: collapse; width: 132.65602322206095%; height: 229px;">
<tbody>
<tr>
<td style="width: 22.37704918032787%; text-align: center;">制限の範囲</td>
<td style="width: 24.562841530054644%; text-align: center;">名前</td>
<td style="width: 20.956284153005466%; text-align: center;">プログラム中の指定方法</td>
<td style="width: 32.103825136612016%; text-align: center;">アクセス許可する範囲</td>
</tr>
<tr>
<td style="width: 22.37704918032787%; text-align: center;">制限が厳しい</td>
<td style="width: 24.562841530054644%; text-align: center;">private</td>
<td style="width: 20.956284153005466%; text-align: center;">private</td>
<td style="width: 32.103825136612016%; text-align: center;">自分自身のクラスのみ</td>
</tr>
<tr>
<td style="width: 22.37704918032787%; text-align: center;">↑</td>
<td style="width: 24.562841530054644%; text-align: center;">package private</td>
<td style="width: 20.956284153005466%; text-align: center;">(何も書かない)</td>
<td style="width: 32.103825136612016%; text-align: center;">自分と同じパッケージに属するクラス</td>
</tr>
<tr>
<td style="width: 22.37704918032787%; text-align: center;">↓</td>
<td style="width: 24.562841530054644%; text-align: center;">protected</td>
<td style="width: 20.956284153005466%; text-align: center;">protected</td>
<td style="width: 32.103825136612016%; text-align: center;">自分と同じパッケージに属するか自分を継承したクラス</td>
</tr>
<tr>
<td style="width: 22.37704918032787%; text-align: center;">制限が緩い</td>
<td style="width: 24.562841530054644%; text-align: center;">public</td>
<td style="width: 20.956284153005466%; text-align: center;">public</td>
<td style="width: 32.103825136612016%; text-align: center;">全てのクラス</td>
</tr>
</tbody>
</table>


### トップレベル
#### 宣言方法
クラスのアクセス制御　`アクセス修飾子　class{・・・}`
#### アクセス修飾子
<table style="border-collapse: collapse; width: 134.39767779390422%; height: 169px;">
<tbody>
<tr>
<td style="width: 18.096008629989214%; text-align: center;">制限</td>
<td style="width: 23.48975188781014%; text-align: center;">名前</td>
<td style="width: 25.970873786407765%; text-align: center;">プログラム中の指定方法</td>
<td style="width: 32.44336569579288%; text-align: center;">アクセスを許可する範囲</td>
</tr>
<tr>
<td style="width: 18.096008629989214%; text-align: center;">厳しい</td>
<td style="width: 23.48975188781014%; text-align: center;">package private</td>
<td style="width: 25.970873786407765%; text-align: center;">(何も書かない)</td>
<td style="width: 32.44336569579288%; text-align: center;">自分と同じパッケージに属するクラス</td>
</tr>
<tr>
<td style="width: 18.096008629989214%; text-align: center;">緩い</td>
<td style="width: 23.48975188781014%; text-align: center;">public</td>
<td style="width: 25.970873786407765%; text-align: center;">public</td>
<td style="width: 32.44336569579288%; text-align: center;">全てのクラス</td>
</tr>
</tbody>
</table>