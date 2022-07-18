/* WriteParameter
 * Coord系のメソッドCoord.write()用のアノテーションです。
 * 修正する場合は[@Pattern]と[message]を編集してください。
 *
 */
package kon.lib.debug.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retenthin(RUNTIME)
@Constraint(validateBy = {})
@Pattern(regexp = "~data/result/[a-z|A-Z|0-9]{14}.txt")
public @interface WritePamameter{
    String message() default "出力ファイルのパスは\"data/result/〜〜〜.txt\"です。\nまたファイルパスは最大30文字です。\n不都合がある場合はkon/lib/debug/WriteParameter.javaを編集してください。";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}