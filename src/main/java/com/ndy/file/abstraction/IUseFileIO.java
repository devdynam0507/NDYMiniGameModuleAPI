package com.ndy.file.abstraction;

public interface IUseFileIO<T> {

    public void save(); /* File I/O 중 Save 를 담당하는 메소드 */
    public T load(); /* File I/O 중 Load 를 담당하는 메소드 */
    public void initialize(); /* File I/O 를 하기위한 준비 메소드 */
    public boolean delete(); /* File I/O 중 File Delete 를 담당하는 메소드 */
    public boolean exists(); /* File I/O 중 File Exists Check 를 담당하는 메소드 */

}
