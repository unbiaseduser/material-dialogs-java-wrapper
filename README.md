# material-dialogs-java-wrapper
[Material Dialogs](https://github.com/afollestad/material-dialogs) wrapper API for Java projects.

## Including in your project
Add `jitpack.io` repository to your list of repos:
```gradle
maven { url "https://jitpack.io" }
```
```gradle
//Each module corresponds to the wrapped library's functionality.
implementation 'com.github.unbiaseduser.material-dialogs-java-wrapper:core:1.0'
implementation 'com.github.unbiaseduser.material-dialogs-java-wrapper:bottomsheets:1.0'
implementation 'com.github.unbiaseduser.material-dialogs-java-wrapper:color:1.0'
implementation 'com.github.unbiaseduser.material-dialogs-java-wrapper:datetime:1.0'
implementation 'com.github.unbiaseduser.material-dialogs-java-wrapper:files:1.0'
implementation 'com.github.unbiaseduser.material-dialogs-java-wrapper:input:1.0'
implementation 'com.github.unbiaseduser.material-dialogs-java-wrapper:lifecycle:1.0'
```

## Usage
This wrapper follows the wrapped library's structure to the T.

General notes: All classes with names ending with `Options` have their corresponding `Builder` class. I expect you to know how to use the builder pattern at this point, yes?

### Core
All the mirrored APIs of the `core` module are included in the `MaterialDialogWrapper` class.
```java
final var wrapper = new MaterialDialogWrapper(requireContext());
//use the wrapped APIs with `wrapper`
```

### Bottom sheets
Instead of `MaterialDialogWrapper`, use `MaterialBottomSheetDialogWrapper` instead.
```java
final var wrapper = new MaterialBottomSheetDialogWrapper(requireContext());
```

## Note
All the methods below can be used with both the `MaterialDialogWrapper` and `MaterialBottomSheetDialogWrapper` classes. After calling them, you must call `show()` yourself.
### Color
Use the static methods in the `MDColorPicker` class:
```java
MDColorPicker.colorChooser(wrapper, new ColorPickerOptions.Builder(new int[]{Color.BLACK, Color.BLUE}).build());
```
### Date-time
Use the static methods in the `MDDatePicker`, `MDTimePicker` and `MDDateTimePicker` classes:
```java
MDDatePicker.datePicker(wrapper, new DatePickerOptions.Builder().build());
//and so on for the other classes
```
### Files
Use the static methods in the `MDFilePicker` and `MDFolderPicker` classes:
```java
MDFilePicker.fileChooser(wrapper, new FileFolderPickerOptions.Builder(requireContext()).build());
//and so on for the other class
```
### Input
Use the static methods in the `MDInput` class:
```java
MDInput.input(wrapper, new InputOptions.Builder().build());
```
### Lifecycle
Use the static methods in the `MDLifecycle` class:
```java
MDLifecycle.lifecycleOwner(wrapper, getViewLifecycleOwner());
```
