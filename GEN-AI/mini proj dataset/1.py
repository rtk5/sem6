import random
import json

policies = [
    ("No hardcoded discounts", "discount"),
    ("Payments must be logged", "payment"),
    ("No direct DB access for business logic", "db"),
    ("Use approved vendor SDKs only", "vendor"),
    ("Customer PII must be accessed via service layer", "pii"),
]

severities = ["low", "medium", "high"]

def generate_sample():
    policy, category = random.choice(policies)

    violation = random.choice([True, False])

    if category == "discount":
        if violation:
            code = "def apply_discount(): DISCOUNT = 0.2"
        else:
            code = "def apply_discount(): return get_discount_from_config()"

    elif category == "payment":
        if violation:
            code = "def pay(): charge(); update_db()"
        else:
            code = "def pay(): AuditLogger.log(); charge(); AuditLogger.log()"

    elif category == "db":
        if violation:
            code = "db.execute('UPDATE orders SET status=paid')"
        else:
            code = "OrderService.update_status(order)"

    elif category == "vendor":
        if violation:
            code = "sdk = __import__('random_sdk'); sdk.charge()"
        else:
            code = "sdk = get_approved_sdk(); sdk.charge()"

    elif category == "pii":
        if violation:
            code = "db.execute('SELECT email FROM users')"
        else:
            code = "CustomerService.get_email(user_id)"

    return {
        "code": code,
        "policy": policy,
        "violation": violation,
        "severity": random.choice(severities) if violation else "none"
    }

dataset = [generate_sample() for _ in range(400)]

with open("policy_dataset.json", "w") as f:
    json.dump(dataset, f, indent=2)

print("✅ Dataset generated with 400 samples")