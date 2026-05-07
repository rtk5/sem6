from PyPDF2 import PdfReader, PdfWriter
import os

def process_and_merge_pdfs(input_folder, output_file):
    writer = PdfWriter()

    for filename in sorted(os.listdir(input_folder)):
        if filename.endswith(".pdf"):
            filepath = os.path.join(input_folder, filename)
            reader = PdfReader(filepath)

            num_pages = len(reader.pages)

            print(f"Processing {filename} ({num_pages} pages)")

            # Add all pages
            for page in reader.pages:
                writer.add_page(page)

            # If odd, add blank page
            if num_pages % 2 != 0:
                print(f"Adding blank page to {filename}")
                writer.add_blank_page(
                    width=reader.pages[0].mediabox.width,
                    height=reader.pages[0].mediabox.height
                )

    # Write final merged PDF
    with open(output_file, "wb") as f:
        writer.write(f)

    print(f"\nMerged PDF saved as: {output_file}")


# 👉 Usage
input_folder = "pdfs"       # folder containing your PDFs
output_file = "merged.pdf"  # final output file

process_and_merge_pdfs(input_folder, output_file)