def decode(text_in, shift):
    decoded_text = ""
    for char in text_in:
        if char.isalpha():
            shift_base = ord('A') if char.isupper() else ord('a')
            decoded_char = chr((ord(char) - shift_base - shift) % 26 + shift_base)
            decoded_text += decoded_char
        else:
            decoded_text += char
    return decoded_text
def encode(text_in,shift):
    encoded_text = ""
    for char in text_in:
        if char.isalpha():
            shift_base = ord('A') if char.isupper() else ord('a')
            encoded_char = chr((ord(char) - shift_base + shift) % 26 + shift_base)
            encoded_text += encoded_char
        else:
            encoded_text += char
    return encoded_text
def main():
    text = input("Enter the text: ")
    shift = int(input("Enter the shift value: "))
    choice = input("Do you want to encode or decode? (e/d): ").lower()

    if choice == 'e':
        result = encode(text, shift)
        print(f"Encoded text: {result}")
    elif choice == 'd':
        result = decode(text, shift)
        print(f"Decoded text: {result}")
    else:
        print("Invalid choice. Please enter 'e' for encode or 'd' for decode.")

main()